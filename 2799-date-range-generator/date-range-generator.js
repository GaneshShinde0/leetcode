/**
 * @param {string} start
 * @param {string} end
 * @param {number} step
 * @yields {string}
 */

var dateRangeGenerator0 = function (start, end, step) {
    const startDate = new Date(start);
    const endDate = new Date(end);
    const dateList = [];
    while(startDate<=endDate){
        dateList.push(formatDate(startDate));
        startDate.setDate(startDate.getDate()+step);
    }
    return dateList;
};

function formatDate(date){
    const year = date.getFullYear();
    const month = String(date.getMonth()+1).padStart(2,'0');
    const day = String(date.getDate()).padStart(2,'0');
    return `${year}-${month}-${day}`;
}
var dateRangeGenerator1 = function*(start, end, step){
    const startDate = new Date(start);
    const endDate = new Date(end).getTime();

    while(startDate.getTime()<=endDate){
        const date = String(startDate.getDate()).padStart(2,'0');
        const month = String(startDate.getMonth()+1).padStart(2,'0');
        const year = String(startDate.getFullYear()).padStart(2,'0');
        yield `${year}-${month}-${date}`;
        const next = startDate.getDate()+step;
        startDate.setDate(next);
    }
};

var dateRangeGenerator = function*(start, end, step){
    const startDate = new Date(start);
    const endDate = new Date(end);

    while(startDate<=endDate){
        yield startDate.toISOString().split('T')[0].trim();
        startDate.setDate(startDate.getDate()+step);
    }
}
/**
 * const g = dateRangeGenerator('2023-04-01', '2023-04-04', 1);
 * g.next().value; // '2023-04-01'
 * g.next().value; // '2023-04-02'
 * g.next().value; // '2023-04-03'
 * g.next().value; // '2023-04-04'
 * g.next().done; // true
 */