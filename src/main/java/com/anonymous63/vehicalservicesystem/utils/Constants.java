package com.anonymous63.vehicalservicesystem.utils;

public class Constants {
    public static final String ADMIN = "Admin";
    public static final String USER = "User";

    public enum Operation {
        SAVE(1, "Save"),
        UPDATE(2, "Update"),
        DELETE(3, "Delete"),
        FIND_BY_ID(4, "FindById"),
        FIND_ALL(5, "FindAll"),
        DISABLE(6, "Disable"),
        ENABLE(7, "Enable");

        private final int operationId;
        private final String operationName;

        Operation(int operationId, String operationName) {
            this.operationId = operationId;
            this.operationName = operationName;
        }

        public int getOperationId() {
            return operationId;
        }

        public String getOperationName() {
            return operationName;
        }

        public static Operation fromOperationId(int operationId) {
            for (Operation operation : Operation.values()) {
                if (operation.getOperationId() == operationId) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Invalid operationId: " + operationId);
        }
    }

}
