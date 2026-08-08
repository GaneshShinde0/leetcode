
var QueryBatcher = function(queryMultiple, t) {
    this.queryMultiple = queryMultiple;
    this.t = t;
    this.isAvailable = true;
    this.stashed = [];
};

QueryBatcher.prototype.getValue = function(key) {
    return new Promise((resolve)=>{
        if(this.isAvailable){
            this.isAvailable = false;
            this.queryMultiple([key]).then(results=>resolve(results[0]));
            this.cooldown();
            return;
        }
        this.stashed.push({key, resolve});
    });
};

QueryBatcher.prototype.cooldown = function(){
    setTimeout(()=>{
        if(this.stashed.length === 0){
            this.isAvailable = true;
            return;
        }
        const keysToQuery = this.stashed.map(item => item.key);
        const resolvers = this.stashed.map(item => item.resolve);

        this.stashed = [];
        this.queryMultiple(keysToQuery)
            .then(results=>{
                resolvers.forEach((resolve,idx)=>{
                    resolve(results[idx]);
                });
            });
          this.cooldown();
    },this.t);
};