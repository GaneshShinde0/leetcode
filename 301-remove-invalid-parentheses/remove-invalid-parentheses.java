/*
Recursion, Stack, Backtracking
*/
/*
Approach 1 : Backtracking
Intuition: 

    - Parentheses can be arranged in different ways.
    - if at any point ) is greater than ( then expresion is invalid.
    - THe only condition is that we should be removing the minimum number of brackets to make an invalid expression valid. If this condition was not present, we could potentially remove most of the brackets and come down to dsay 2 brackets in the end which form () and that would be valid expression.
    - There are multiple ways  to reach same solution, but we can remove only k brackets(longest string/expression).

    - Which brackets should be removed? try out all options.
    - For Every bracket we have two choices.
        - Either it can be considered as part of final expression.
        - It can be igored ie. we cna delete it form our final expression.
    - Multiple options and we have no strategy, -> try out all options and see which ones lead to an answer.

Algorithm:
    1. Initialize an array that will store all of our valid expressions finally.
    2. Start with the leftmost bracket in the given sequence and proceed right in the recursion.
    3. State of recursion is defined by the index which we are currently processing in the original expression. Let this index be represented by the character i. Also, we have two different variables leftCount and rightCount that represent the number of left and right parentheses we have added to our expression till now. These are the parentheses that were considered.
    4. If the current character i.e. S[i] considereing s is the expression string is neither a closing or an opening parentheseis, then we simply add this character to our final solution string for the current recursion.
    5. However, if the current character is either of two brackets i.e. S[i] == '(' or S[i]==')', then we have two options, we cna either discard this character by marking it an invalid character or we can considre this bracket to be a part of the final expression.
    6. When all of the parenthesis in the original expression have been processed, we simply check if the expression represented by expr i.e. the eexpression formed till now is valid one or not. The way we check if the final expression is valid or not is by looking at the values in leftCount and rightCount. for expression to be valid *leftCount==rightCount*. If is is indeed valid, then it ccould be one of our possible solutions. 
        - Even though we have a valid expression, we also need to keep track of the number of removals we did to get this expression. This sis done by another varaible passed in the recursion called remCount.
        - Once recursion finishes we check if the current value of remCOunt is < the least number of steps we took to form a valid expression till now i.e. the global minima. If this is not the case, we dont record the new expression, else we record it.

One small optimization that we can do from an implementation perspecitve is introducing some sort of pruning in our algorithm, Right now we simply go till the very end i.e. process all the parentheses and when we are done processing all of them, we check if the expression we have can be coonsidered or not.

We have to wait till very end to decide if the expression formed in recursion is valid expression or not. Is there a way fr us to cutoff from some of the recursion paths early on because they wouldn't lead to a solution? the answer to this is yes. 

Idea for optimization:
    - For a left bracket encountered during recursion. If we decide to consider it, then it may nnot lead to an invvalid final expression. it may lead to an invalid expression eventually. if there are no matching closing bracket available afterwards. But, we don't know for sure if this will happen or not.

    However, for a closing bracket, if we decide to keep it as part of our final expression(Remember for every bracket we have two options, either to keep it or removve it and recurse further). and there is no corresponding opening bracket to match it in the expression till now, then it will definitiely lead to an invalid expression no matter what we do afterwards.

Example: (())) 
    - In this case the third closing bracket will make the expression invalid. No matter what comes afterward, this will give us an invalid expresssion and if such a thing happens, we shouldn't recurse further and simply prune the recursion tree.
    - This is why in adition to the index of the original string/ expression which we are currently processing and the expression string formed till now, we also keep track of the number of left and right parentheses. Whenever we keep a left parentheseis in the expression, we increment its counter. For a right parentheseis, we check if rightCount<leftCount. If this is the case then only we consider that right parenthesis and recurse further. Otherwise we don't as we know it will make the expression invvalid. This simple optimization saves a lot of runtime.



###########################
Complexity Analysis:
- Time Complexity: O(2^N) since the worst case will have only left parentheses in the expression and for every bracket we will have two options i.e.e whethere to remove it or consider it. Considering that the expresiion has n parenthesis, the time compleixyt will be O(2^N)
- Space Complexity: O(N) We are resorting to a recursive solution and for a recursive solution there is always a stack space used as internal function. States are saved onto stack during recursion. The maximum depth of recursion decides the stack space used. Since we process one character at a time and the base case for recursion is when we have processed all of the characters of the expression string. The size of the stack would be O(N). Note that twe are not considerin the space required to store the valid expressions. We only count the intermediate space here.

*/

/*

Approach 2: Limited Backtracking!
Although the previous solution does get accepted on the platform, it is a very inefficient solution because we try removing each and every possible parentheses from the expresssion and in the end we check two things.
1. If the expression is valid or not.
2. If the total number of removed parentheses removed in the current recursion is less than the global minimum till now or not.

We cannot determine which of the parentheses are misplaced because as the problem statement puts across, we can remove multiple combinatioons and end up with a valid expression. This means there can be multiple valid expression from a single invalid expression and we have to find all of them.

The one thing all these valid expressions have in common is that they will all be of the same length i.e, as compared to the original expression, all of these expressions will have the same number of characters removed.

What if we could determine this count?

What if in addition to determining this count of characters to be rmoved, could could also dermine the number of left parentheses and number of right parantheses to be removed from the original expression to get any valid expression?

This would cut down the computatiosns immensely and the runtime would plummet as a result. The reson for this is, if we knew how many left and right parentheses are to be removed from the original expression to get a valid expression, we would cut down on so may unwanted recursive calls.

Imagine the original expression to be 1000 characters with only 3 misplaced ( parentheses and 2 misplaced )/ In our previous solution we would end up trying to remove each one of left and right parentheses and try to reach valid expression in the end where as we should only be trying out removing  3 ( brackets and 2 ) brackets.

This is the exact number ( and ) that have to be removed to get a valid expression, no more or less.

How we can find out number of misplaced left and right parenthesses in given expression.
    1. We process the expression one bracket a time starting from left.
    2. Suppose we encounter an opening bracket i.e. ( it may or may not lead to an invalid expression because there can be a matching ending bracket somewhere in the remaining part of the expression. Here we simply increment the counter keeping track of left parentheses till now. Left+=1
    3. If we encounter a closing bracket, this has two meanings.
        - Either there was no matching opening bracket for this closing bracketand in that case we have an invalid expression. This is the case when left ==0 i.e. when there are no unmatched left brackets available. In such a case we increment another counter say right+=1 to represent mispalced right parentheses.
        - Or we had some unmatched opening bracket avalialbe to match this closing bracket. This is the case when left>0 . In this case we simply decrement the left counter we had i.e. left -= 1
    4. Continue processing the string until all parentheses have been processed.
    5. In the end value of left and right would tell us the nummber of unmatched ( and ) parentheses respectively.

Now that  we have two values available that tell us the total number of left i.e. ( and right i.e. ) parentheses that have to be removed to make the invalid expression valid.

Follwing modifications will be done in approach 1. 

Algorithm: (Almost same with changes)

- The state of the recursion is now defined by five different variables:
    1. Index which represents the current character that we have to process in the original string.
    2. leftCount which represents the number of left parentheses that have been added to the expression we are building.
    3. rightCount which represents the number of right parentheses that have been added to the expression we are building.
    4. leftRem is the number of left parentheses that remain to be removed.
    5. rightRem represents the number of right parentheses that remain to be removed. Overall, for the final expression to be valid, leftRem == 0 and rightRem == 0;

- When we decide to not consider a parenthesis i.e. delete a parenthesis, be it a left or a right parentheses, we have to consider their corresponding remaining counts as well. This means that we can only discard a left parentheses if leftRem>0 and similarly for the right one we will check for rightRem>0.
- There are no changes to checks for considering a parenthesis. Only the conditions change for discarding a parenthesis.
- Condition for an expression being balid in the base case would now become leftRem==0 and reightRem==0 Note that we don't have to check if leftCount == rightCount anymore because in the case of a valid expression, we would have removed all the misplaed or invalid parenthesis by the time the recursion ends. So the only check we need if leftRem == 0 and rightRem == 0;


Most important thing here is that we have completely gotten rid of checking if the number of parentheses removed is lesser than the current minimum or not. the reason for this is we always remove the smae number of parentheses as defined by leftRem + rightRem at the start of recursion.


*/

class Solution{
    private Set<String> validExpressions = new HashSet<String>();
    private void recurse(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder expression){
        // If we reached the end of the string, just check if the resulting expression is valid or not and also if we chave removed the total number of left and right parentheses that we should have removed.
        if(index==s.length()){
            if(leftRem == 0 && rightRem==0) this.validExpressions.add(expression.toString());
        }else{
            char character = s.charAt(index);
            int length = expression.length();
            // The discard case. Note that here we have our pruning condition. We don't recurse if the remaining count for that parenthesis is ==0.
            if((character == '(' && leftRem>0)|| (character == ')' && rightRem>0)){
                this.recurse(s, index+1, leftCount, rightCount, leftRem - (character=='('?1:0), rightRem - (character == ')'?1:0), expression);
            }
            expression.append(character);

            // Simply recurse one step further if the current character is not parenthesis. 
            if(character!='(' && character != ')'){
                this.recurse(s, index+1, leftCount, rightCount, leftRem, rightRem, expression);
            }else if(character == '('){
                // Consider an opening bracket.
                this.recurse(s, index+1, leftCount+1, rightCount, leftRem, rightRem, expression);
            }else if(rightCount<leftCount){
                // Consider a closing bracket.
                this.recurse(s, index+1, leftCount, rightCount+1, leftRem, rightRem, expression);
            }
            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }

    public List<String> removeInvalidParentheses(String s){
        int left = 0, right = 0;
        // First we find out the number of misplaced left and right parentheses.
        for(int i=0;i<s.length();i++){
            // Simply record the left one.
            if(s.charAt(i)=='(') left ++;
            else if(s.charAt(i)==')'){
                // If we dont have a matching left, then this is a misplaced right, record it.
                right = left == 0? right+1: right;
                // Decrement count of left parentheses because we have found a right which can be a matching one for the left.
                left = left>0? left-1:left;
            } 
        }
        this.recurse(s, 0, 0,0, left, right, new StringBuilder());
        return new ArrayList<String>(this.validExpressions);
    }
}
class Solution1 {

    private Set<String> validExpressions = new HashSet<String>();
    private int minimumRemoved;

    private void reset(){
        this.validExpressions.clear();
        this.minimumRemoved = Integer.MAX_VALUE;
    }

    private void recurse(String s, int index, int leftCount, int rightCount, StringBuilder  expression, int removedCount){
        // If we have reached the end of string.
        if(index == s.length()){
            // If expression is valid.
            if(leftCount == rightCount){
                // If the current count of removed parentheses is <= the current minimum count 
                if(removedCount<=this.minimumRemoved){
                    // COnvert stringBuilder to string. thei  sis an expensive operation, so we only perform this when needed.
                    String possibleAnswer = expression.toString();
                    // If the current count beats the overall minimum we have till now.
                    if(removedCount<this.minimumRemoved){
                        this.validExpressions.clear();
                        this.minimumRemoved = removedCount;
                    }
                    this.validExpressions.add(possibleAnswer);
                }
            }
        }else{
                char currentCharacter = s.charAt(index);
                int length = expression.length();
                // If the current character is neiter an opening bracket nor a closing one, simply recurse further by adding it to the expression StringBuilder
                if(currentCharacter != '(' && currentCharacter != ')'){
                    expression.append(currentCharacter);
                    this.recurse(s, index+1, leftCount, rightCount, expression, removedCount);
                    expression.deleteCharAt(length);
                }else{
                    // Recursion where we delete the current character and move forward.
                    this.recurse(s, index+1, leftCount, rightCount, expression, removedCount+1);
                    expression.append(currentCharacter);

                    // If it's an opening parenthesis, consider it and recurse
                    if(currentCharacter == '('){
                        this.recurse(s, index+1, leftCount+1, rightCount, expression, removedCount);
                    }else if(rightCount<leftCount){
                        // For a closing parenthesis, only recurse if right<left
                        this.recurse(s, index+1, leftCount, rightCount+1, expression, removedCount);
                    }

                    // Undoing the append operation for other recursions.
                    expression.deleteCharAt(length);
                }
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        this.reset();
        this.recurse(s,0,0,0, new StringBuilder(), 0);
        return new ArrayList(this.validExpressions);
    }
}