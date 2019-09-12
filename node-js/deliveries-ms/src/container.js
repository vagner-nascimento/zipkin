const { createContainer, asClass, asFunction, asValue } = require('awilix');
const { scopePerRequest } = require('awilix-express');

const controllers = require('src/interfaces/http/controllers');
const router = require('src/interfaces/http/router');
const Server = require('src/interfaces/http/Server');
const Application = require('src/app/Application');
const CreateDeliveryOperation = require('src/app/operation/CreateDeliveryOperation');
const LocationService = require('src/app/services/LocationService');
const LocationClient = require('src/interfaces/http/clients/LocationClient');

const config = require('../config');

const container = createContainer();

// Values
container
    .register({ controllers: asValue(controllers) })
    .register({ config: asValue(config) });

// Functions
container
    .register({ router: asFunction(router).singleton() });

// Classes
container    
    .register({ Application: asClass(Application).singleton() })
    .register({ Server: asClass(Server).singleton() })
    .register({ LocationService: asClass(LocationService).singleton() })
    .register({ CreateDeliveryOperation: asClass(CreateDeliveryOperation) })
    .register({ LocationClient: asClass(LocationClient).singleton() })

// Middlewares
container.register({
    containerMiddleware: asValue(scopePerRequest(container))
});

module.exports = container;