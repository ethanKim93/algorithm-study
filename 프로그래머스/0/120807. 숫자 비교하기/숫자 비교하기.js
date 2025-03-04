function solution(num1, num2) {
    var answer = 1;
    let result = num1 === num2;
    if(!result){
        answer = -1;
    }
    return answer;
}