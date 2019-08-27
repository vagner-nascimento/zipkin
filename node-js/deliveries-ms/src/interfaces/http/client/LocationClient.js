const { get } = require('http');

class LocationClient {

    async getLocationByAddressId(addressId) {

        //TODO: It is not working yet
        const url = 'http://localhost:8083/location/' + addressId + '/address'
        get(url, response => {

            Promise.resolve(response.body);
        });
    }
}

module.exports = LocationClient;