const { Router } = require('express');
const { inject } = require('awilix-express');
const httpStatus = require('http-status');

const locationController = {
    
    get router() {
        const router = Router();
        router.get('/location/:addressId/address', inject(this.getByAddressId));

        return router;
    },

    getByAddressId: ({ GetLocationByAddressIdOperation }) => async (req, res, next) => {

        try {
            console.log('req.params', req.params);
            const location = await GetLocationByAddressIdOperation.execute(req.params.addressId);

            res
                .status(httpStatus.OK)
                .json(location);
        } catch (error) {
            console.log('error', error);
            next;
        }
    }
};

module.exports = locationController;