const { Router } = require('express');
const { inject } = require('awilix-express');
const httpStatus = require('http-status');

const deliveriesController = {
    
    get router() {
        const router = Router();
        router.post('/deliveries/', inject(this.create));

        return router;
    },

    create: ({ CreateDeliveryOperation }) => async (req, res, next) => {

        try {
            console.log('req.body', req.body);
            const delivery = await CreateDeliveryOperation.execute(req.body);

            res
               .status(httpStatus.CREATED)
               .json(delivery);
        } catch (error) {
            console.log('error', error);
            next;
        }
    }
};

module.exports = deliveriesController;