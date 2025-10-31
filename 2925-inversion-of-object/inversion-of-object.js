/**
 * @param {Object|Array} obj
 * @return {Object}
 */
var invertObject = function(obj) {
    const invertedObj = {};
    for(let key in obj){
        let value = obj[key];
        if(invertedObj[value]){
            Array.isArray(invertedObj[value])?invertedObj[value].push(key):invertedObj[value] = [invertedObj[value],key];
        }else{
            invertedObj[value]=key;
        }
    }
    return invertedObj;
};