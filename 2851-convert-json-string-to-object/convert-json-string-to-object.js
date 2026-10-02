var jsonParse = function(str) {
   let i = 0;

   return parseValue();

   function parseValue() {
      switch (str[i]) {
         case '"':
            return parseString();
         case '{':
            return parseObject();
         case '[':
            return parseArray();
         case 't':
         case 'f':
         case 'n':
            return parseLiteral();
         default:
            return parseNumber();
      }
   }

   function parseNumber() {
      let start = i;

      if (str[i] === '-') {
         i++;
      }

      while (i < str.length && isDigit(str[i])) {
         i++;
      }

      if (str[i] === '.') {
         i++;
         while (i < str.length && isDigit(str[i])) {
            i++;
         }
      }

      return Number(str.slice(start, i));
   }

   function isDigit(n) {
      return n >= '0' && n <= '9';
   }

   function parseString() {
      let result = '';
      i++;

      while (i < str.length && str[i] != '"') {
         result += str[i];
         i++;
      }

      i++;
      return result;
   }

   function parseObject() {
      i++;

      const result = {};

      while (i < str.length && str[i] !== '}') {
         const key = parseString();
         expectChar(':');
         const value = parseValue();

         result[key] = value;
         if (str[i] === ',') {
            i++;
         }
      }

      i++;
      return result;
   }

   function parseArray() {
      i++;

      const result = [];

      while (i < str.length && str[i] !== ']') {
         const value = parseValue();
         result.push(value);
         if (str[i] === ',') {
            i++;
         }
      }

      i++;
      return result;
   }

   function parseLiteral() {
      if (str.startsWith('true', i)) {
         i += 4; // length of 'true'
         return true;
      } else if (str.startsWith('false', i)) {
         i += 5; // length of 'false'
         return false;
      } else if (str.startsWith('null', i)) {
         i += 4; // length of 'null'
         return null;
      }
   }

   function expectChar(char) {
      if (str[i] !== char) {
         throw new Error(`Expected '${char}' at position ${i}`);
      }
      i++;
   }
}
