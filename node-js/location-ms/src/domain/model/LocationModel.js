class LocationModel {

    constructor({ locationId, addressId, country, state, city, street, number, deactivationDate }) {
        
        this.locationId = locationId;
        this.addressId = addressId;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
        this.deactivationDate = deactivationDate
    }
}

module.exports = LocationModel;