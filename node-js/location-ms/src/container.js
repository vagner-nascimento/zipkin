const { createContainer, asClass, asFunction, asValue } = require('awilix');
const { scopePerRequest } = require('awilix-express');

const controllers = require('src/interfaces/http/controllers');
const router = require('src/interfaces/http/router');
const Server = require('src/interfaces/http/Server');

const Application = require('src/app/Application');
const GetLocationByAddressIdOperation = require('src/app/operation/GetLocationByAddressIdOperation');

const GetLocationService = require('src/app/services/GetLocationService');

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
    .register({ GetLocationService: asClass(GetLocationService).singleton() })
    .register({ GetLocationByAddressIdOperation: asClass(GetLocationByAddressIdOperation) });

// Middlewares
container.register({
    containerMiddleware: asValue(scopePerRequest(container))
});

module.exports = container;