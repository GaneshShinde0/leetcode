
var delayAll = function(functions, ms) {
    const newFunctions = [];
    functions.forEach(el=>{
        const newFuncWithPromise = () =>{
            return new Promise((resolve,reject)=>{
                setTimeout(()=>{
                    async function getResult(){
                        try{
                            const res = await el();
                            resolve(res);
                        }catch(err){
                            reject(err);
                        }
                    }
                    getResult();
                },ms);
            });
        }
        newFunctions.push(newFuncWithPromise);
    });
    return newFunctions;
};

