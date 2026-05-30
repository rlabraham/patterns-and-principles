package com.rabraham.patterns.other.envelope;

public class EnvelopePatternDemo {

    // 1. Define the Envelope class to hold metadata and payload
    public static class Envelope<T> {
        private String messageId;
        private long timestamp;
        private String schemaVersion;
        private T payload; // The original data

        public Envelope(String messageId, String schemaVersion, T payload) {
            this.messageId = messageId;
            this.timestamp = System.currentTimeMillis();
            this.schemaVersion = schemaVersion;
            this.payload = payload;
        }

        // Getters
        public String getMessageId() { return messageId; }
        public long getTimestamp() { return timestamp; }
        public String getSchemaVersion() { return schemaVersion; }
        public T getPayload() { return payload; }
    }

    // 2. Define the payload class
    public static class OrderEvent {
        private String orderId;
        private double amount;

        public OrderEvent(String orderId, double amount) {
            this.orderId = orderId;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "OrderEvent{orderId='" + orderId + "', amount=" + amount + "}";
        }
    }

    // 3. Demonstrate usage
    public static void main(String[] args) {
        // Create the original data (payload)
        OrderEvent myOrder = new OrderEvent("ORD-9988", 250.50);

        // Wrap the payload in an Envelope
        Envelope<OrderEvent> wrappedEnvelope = new Envelope<>(
                "MSG-12345",
                "v1.0",
                myOrder
        );

        // Process the envelope metadata and payload
        System.out.println("Envelope ID: " + wrappedEnvelope.getMessageId());
        System.out.println("Schema: " + wrappedEnvelope.getSchemaVersion());
        System.out.println("Payload Data: " + wrappedEnvelope.getPayload());
    }
}
