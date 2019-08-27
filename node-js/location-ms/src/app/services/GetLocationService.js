const LocationModel = require('src/domain/model/LocationModel');

class GetLocationService {

    getLocationByAddressId(addressId) {

        const locationData = {
            locationId: 669,
            addressId: addressId,
            country: 'Brazil',
            state: 'RS',
            city: 'Porto Alegre',
            street: 'Ipiranga Avenue',
            number: '7200',
            deactivationDate: null
        };

        return new LocationModel(locationData);
    }
}

module.exports = GetLocationService;