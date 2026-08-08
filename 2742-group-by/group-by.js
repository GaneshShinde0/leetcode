/**
 * @param {Function} fn
 * @return {Object}
 */

Array.prototype.groupBy = function(fn) {
    let obj={};
    for(const item of this){
        const key=fn(item);
        if(key===undefined) continue;
        if(!obj[key]){
            obj[key]=[];
        }
        obj[key].push(item);
    }
    return obj;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */