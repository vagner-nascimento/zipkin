class GetLocationByAddressIdOperation {
     
    constructor({ GetLocationService }) {

         this.getLocationService = GetLocationService;
    }

    async execute(addressId) {

        const location = this.getLocationService.getLocationByAddressId(addressId);
        
        if(!location)
            throw new Error('Location not found');
        
        return location;
    }
}

module.exports = GetLocationByAddressIdOperation;