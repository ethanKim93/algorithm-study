function solution(l, r) {
    var answer = [];
    for(let i = l ; i < r+1 ; i++ ){
        let n = i.toString();
        
        let flag = true;
        
        for (let j = 0; j < n.length; j++) {
          let c = Number(n[j]);
          if(c % 5 !== 0){
              flag = false
          }
        }
        if(flag){
            answer.push(Number(n))
        }
    }
    
    if(answer.length === 0){
        answer.push(-1);
    }
    return answer;
}