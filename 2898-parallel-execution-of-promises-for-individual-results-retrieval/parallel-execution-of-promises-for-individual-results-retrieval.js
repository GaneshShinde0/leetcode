/**
 * @param {Array<Function>} functions
 * @return {Promise<Array>}
 */
var promiseAllSettled = function(functions) {
    return new Promise((resolve, reject)=>{
        let count = 0;
        const res = Array(functions.length);
        functions.forEach((fn,index)=>{
            fn().then((result)=>{
                res[index] = {'status':"fulfilled","value":result};
                if(++count === res.length) resolve(res);
            },
            (error)=>{
                res[index] = {'status':"rejected","reason":error};
                if(++count == res.length) resolve(res);
            })
        })
    })
};


/**
 * const functions = [
 *    () => new Promise(resolve => setTimeout(() => resolve(15), 100))
 * ]
 * const time = performance.now()
 *
 * const promise = promiseAllSettled(functions);
 *              
 * promise.then(res => {
 *     const out = {t: Math.floor(performance.now() - time), values: res}
 *     console.log(out) // {"t":100,"values":[{"status":"fulfilled","value":15}]}
 * })
 */