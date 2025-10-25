/**
 * @param {Function} fn
 * @return {Function<Promise<number>>}
 */
var promisify = function(fn) {
    
    return async function(...args) {
        return new Promise((resolve,reject)=>{
            function callback(result, error){
                // If error, reject the Promise
                if(error){
                    reject(error);
                }
                // If No error, resolve the promise
                else{
                    resolve(result);
                }
            }
            fn(callback, ...args);
        });
    };
};

/**
 * const asyncFunc = promisify(callback => callback(42));
 * asyncFunc().then(console.log); // 42
 */