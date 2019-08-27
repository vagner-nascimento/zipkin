class LocationService {

    constructor({ LocationClient }) {

        this.locationClient = LocationClient;
    }

    async isValidAddress(addressId) {

        const location = await this.locationClient.getLocationByAddressId(addressId);
        
        return location && !location.deactivationDate;
    }
}

module.exports = LocationService;