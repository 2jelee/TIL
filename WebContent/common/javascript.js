function setOrdering(arrParam){	
    for(var i=0; i<arrParam.length-1; i++){
        for(var j=0; j<(arrParam.length-1)-i; j++){
            if(arrParam[j] > arrParam[j+1]){
                temp= arrParam[j];
                arrParam[j] = arrParam[j+1];
                arrParam[j+1] = temp;
                        
            }
        }
    }
}
       