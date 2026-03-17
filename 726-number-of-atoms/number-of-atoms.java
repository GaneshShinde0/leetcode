class Solution {

    int index = 0;
    public String countOfAtoms(String formula) {
        Map<String, Integer> finalMap = parseFormula(formula);
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>(finalMap);
        StringBuilder result = new StringBuilder();
        for(String atom: sortedMap.keySet()){
            result.append(atom);
            if(sortedMap.get(atom)>1) result.append(sortedMap.get(atom));
        }
        return result.toString();
    }

    private Map<String, Integer> parseFormula(String formula){
        Map<String, Integer> currMap = new HashMap<>();
        String currAtom = new String();
        String currCount = new String();

        while(index<formula.length()){
            if(Character.isUpperCase(formula.charAt(index))){
                if(!currAtom.isEmpty()){
                    if(currCount.isEmpty()) currMap.put(currAtom,currMap.getOrDefault(currAtom,0)+1);
                    else currMap.put(currAtom,currMap.getOrDefault(currAtom,0)+Integer.parseInt(currCount));
                }
                currAtom = String.valueOf(formula.charAt(index));
                currCount = "";
                index++;
            }else if(Character.isLowerCase(formula.charAt(index))){
                currAtom+=formula.charAt(index);
                index++;
            }else if(Character.isDigit(formula.charAt(index))){
                currCount += formula.charAt(index);
                index++;
            }else if(formula.charAt(index)=='('){
                index++;
                Map<String,Integer> nestedMap = parseFormula(formula);
                for(String atom:nestedMap.keySet()){
                    currMap.put(atom, currMap.getOrDefault(atom,0)+nestedMap.get(atom));
                }
            }else if(formula.charAt(index)==')'){
                if(!currAtom.isEmpty()){
                    if(currCount.isEmpty()) currMap.put(currAtom,currMap.getOrDefault(currAtom,0)+1);
                    else currMap.put(currAtom,currMap.getOrDefault(currAtom,0)+Integer.parseInt(currCount));
                }
                index++;
                StringBuilder multiplier = new StringBuilder();
                while(index<formula.length() && Character.isDigit(formula.charAt(index))){
                    multiplier.append(formula.charAt(index));
                    index++;
                }
                if(multiplier.length()>0){
                    int mult = Integer.parseInt(multiplier.toString());
                    for(String atom:currMap.keySet()){
                        currMap.put(atom, currMap.get(atom)*mult);
                    }
                }
                return currMap;
            }
        }
        if(!currAtom.isEmpty()){
            if(currCount.isEmpty()) currMap.put(currAtom,currMap.getOrDefault(currAtom,0)+1);
            else currMap.put(currAtom,currMap.getOrDefault(currAtom,0)+Integer.parseInt(currCount));
        }
        return currMap;
    }
}