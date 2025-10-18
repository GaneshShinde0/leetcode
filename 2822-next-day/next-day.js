Date.prototype.nextDay = function() {
    const daysInMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    const year = this.getFullYear();
    const month = this.getMonth();    
    const day = this.getDate();      
    
    // If the current year is a leap year
    const isLeapYear = (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
    if (isLeapYear) {
        daysInMonth[1] = 29; // Feb days  
    }

    const maxDays = daysInMonth[month];
    
    let nextYear = year;
    let nextMonth = month;
    let nextDay = day + 1;

    // Check if the next day exceeds the maximum days in the current month
    if (nextDay > maxDays) {
        nextDay = 1;         
        nextMonth += 1;
        if (nextMonth > 11) {
            nextMonth = 0;
            nextYear += 1;
        }
    }

    // YYYY-MM-DD
    const formattedDate = `${nextYear}-${String(nextMonth + 1).padStart(2, '0')}-${String(nextDay).padStart(2, '0')}`;
    return formattedDate;
};
