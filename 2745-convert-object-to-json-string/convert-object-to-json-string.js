/*
First we need to check if the input object is null and if yes return string null, Because in JavaScript typeof null returns object.
- Next, we check if the objeect is an array using the Array.isArray() method, It takes one argument and returns true of the argument is an array.
    - If it's an array, iterate over each element and recursively call the jsonStringify function on each element to properly handle nested objects or arrays withing the array.
    - The resulting JSON string representation of each element is stored in the elements array.
    - Finally, we join the elements together with commas (',') using the join() method and enclosed in square brackets ('[]') to represent array in JSON.

- Now, if the object is not an array but an object with key-valye pair, it iterates ober the object's keys using Object.keys()
    - For each key, we recursively call the jsonStringify function on the corresponding value and store the resulting JSON string representation in the keyValuePairs array.
    - The keyValuePairs array contains strings representing each key-value pair.
    - Finally, the key-value pairs are joined together with commas (',') using the join() method and enclosed in curly braces to represent the object in JSON.
- If the objet is a string, we will wrap the string value in double quotes to represent it properly in JSON.

*/
/**
 * @param {null|boolean|number|string|Array|Object} object
 * @return {string}
 */
var jsonStringify = function(object) {
    if(object===null) return 'null';
    if(Array.isArray(object)){
        const elements = object.map((element)=> jsonStringify(element));
        return `[${elements.join(',')}]`;
    }
    if(typeof object === 'object'){
        const keys = Object.keys(object);
        const keyValuePairs = keys.map((key)=> `"${key}":${jsonStringify(object[key])}`);
        return `{${keyValuePairs.join(',')}}`;
    }

    if(typeof object === 'string') return `"${object}"`;
    return object;
};