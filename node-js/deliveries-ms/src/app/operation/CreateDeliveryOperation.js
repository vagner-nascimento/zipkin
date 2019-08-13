const DeliveryModel = require('../../domain/model/DeliveryModel');

class CreateDeliveryOperation {
     
    constructor({ LocationService }) {

         this.locationService = LocationService;
    }

    async execute(delivery) {

        const deliveryModel = new DeliveryModel(delivery);

        if(!this.locationService.isValidAddress(deliveryModel.addressId))
            throw new Error('Invalid address');
        
        return deliveryModel;
    }
}

module.exports = CreateDeliveryOperation;