/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var undefinedToNull = function(obj) {
    if(typeof obj !== 'object' || obj === null){
        return obj!== undefined?obj:null;
    }
    if(Array.isArray(obj)){
        return obj.map(item => undefinedToNull(item));
    }

    const newObj = {};

    for(const key in obj){
        newObj[key]=undefinedToNull(obj[key]);
    }

    return newObj;
};

/**
 * undefinedToNull({"a": undefined, "b": 3}) // {"a": null, "b": 3}
 * undefinedToNull([undefined, undefined]) // [null, null] 
 */