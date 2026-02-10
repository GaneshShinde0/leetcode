/*
Recursion, Stack, Backtracking

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

*/
class Solution {

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