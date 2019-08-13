class DeliveryModel {

    constructor({ addressId, deliveryDate, freightPrice }) {
        
        this.addressId = addressId;
        this.deliveryDate = deliveryDate;
        this.freightPrice = freightPrice;
    }
}

module.exports = DeliveryModel;