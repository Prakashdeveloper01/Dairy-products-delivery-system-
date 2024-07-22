package com.demo.raj.kumar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Delivery {

    private int deliveryId;
    private String deliveryStatus;
    private Date deliveryDate;
    private String trackingNumber;

    // Getters and setters
    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    // Method to update delivery status
    public static boolean updateDeliveryStatus(Connection connection, int orderId, String newStatus) throws SQLException {
        String updateStatusQuery = "UPDATE delivery SET delivery_status = ? WHERE order_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateStatusQuery)) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, orderId);
            int affectedRows = stmt.executeUpdate();

            return affectedRows > 0;
        }
    }
}
