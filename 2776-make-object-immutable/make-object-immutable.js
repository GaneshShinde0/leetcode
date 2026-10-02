var makeImmutable = function(obj) {
  // Define a set of methods that mutate the object or array.
  const methods = new Set(['pop', 'push', 'shift', 'unshift', 'splice', 'sort', 'reverse']);

  // Define the proxy handler object.
  const handler = {
    // 'set' trap throws an error when an attempt is made to modify a property.
    set : function(target, prop) {
      throw Array.isArray(target) ? `Error Modifying Index: ${prop}` : `Error Modifying: ${prop}`;
    },

    // 'get' trap creates a new proxy for nested objects or functions,
    // while returning primitive values and 'prototype' property as is.
    get : function(target, prop) {
      const condition =
        // 'prototype' property is returned as is to avoid potential issues with inheritance.
        prop === 'prototype' ||
        // If property is null, return as is.
        target[prop] === null ||
        // If property is not an object or function, return as is.
        typeof target[prop] !== 'object' &&
        typeof target[prop] !== 'function';

      // If the condition is true, return the property as is, else create a new Proxy.
      return condition ? target[prop] : new Proxy(target[prop], this);
    },

    // 'apply' trap throws an error when a mutating method is called.
    apply : function(target, thisArg, argumentsList) {
      if(methods.has(target.name))
        throw `Error Calling Method: ${target.name}`
      return target.apply(thisArg, argumentsList);
    }
  }

  // Return a new Proxy with the defined handler.
  return new Proxy(obj, handler);
};
