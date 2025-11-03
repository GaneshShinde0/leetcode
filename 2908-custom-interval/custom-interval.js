/**
 * @param {Function} fn
 * @param {number} delay
 * @param {number} period
 * @return {number} id
 */

let intervalIdCounter = 0;
const intervalMap = new Map(); // Store timer ID's
function customInterval(fn, delay, period){
    let count = 0;
    const customId = intervalIdCounter++; // Generate a Unique ID

    function dfs(){
        const timerId = setTimeout(()=>{
            fn(); dfs();
        }, delay+period*count);
        count++;
        intervalMap.set(customId, timerId);
    }
    dfs();
    return customId;
}

/**
 * @param {number} id
 * @return {void}
 */
function customClearInterval(id) {
    const timerId = intervalMap.get(id);
    clearTimeout(timerId);
    intervalMap.delete(id);
}