package com.packaage.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.packaage.entity.Category;

public class CategoryDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private void queryCategoryProductAmount(Category category) {
        String query = "SELECT COUNT(*) FROM product WHERE fk_category_id = ? AND product_is_deleted = false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, category.getId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setTotalCategoryProduct(resultSet.getInt(1));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error in queryCategoryProductAmount: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    public Category getCategory(int categoryId) {
        Category category = new Category();
        String query = "SELECT * FROM category WHERE category_id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error in getCategory: " + e.getMessage());
        } finally {
            closeResources();
        }

        queryCategoryProductAmount(category);
        return category;
    }

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM category";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
                list.add(category);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        for (Category category : list) {
            queryCategoryProductAmount(category);
        }

        return list;
    }

    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}
