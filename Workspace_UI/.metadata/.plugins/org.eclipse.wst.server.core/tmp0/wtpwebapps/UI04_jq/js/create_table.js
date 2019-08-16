
// $table, $tr, $td : 변수
// var 안쓴 "javascript 변수의 hoisting" 이라고 부름.
// javascript 에선 var가 변수.
function makeTable(elem){
   $table = $("<table border=1>"); //table 태그 생성
            // <table border=1></table>
   
    // column 이름 한줄 생성.
   for(var i=0;i<1;i++){
      $tr=$("<tr>");
      // <tr></tr>
      for(var j=0;j<elem.eq(0).children().length;j++){
         $td=$("<td>").append(elem.eq(0).children().eq(j).prop("tagName"));
                            //elem = ROW.  ROW의 첫번째것의 자식들(j)의 태그네임(EMPLOYEE_ID, LAST_NAME..)을 추가
        //<td>EMPLOYEE_ID</td>
        //<td>LAST_NAME</td>
        //<td>EMAIL</td>
        //<td>PHONE_NUMBER</td>
        //<td>HIRE_DATE</td>
         $tr.append($td);
        /* <tr>
                <td>EMPLOYEE_ID</td>
                <td>LAST_NAME</td>
                <td>EMAIL</td>
                <td>PHONE_NUMBER</td>
                <td>HIRE_DATE</td>
            </tr>
        */
      }
      $table.append($tr);
      /*<table border=1>
            <tr>
                <td>EMPLOYEE_ID</td>
                <td>LAST_NAME</td>
                <td>EMAIL</td>
                <td>PHONE_NUMBER</td>
                <td>HIRE_DATE</td>
            </tr>
        </table>
      */
   }
   
   for(var i=0;i<elem.length;i++){ //ROW의 갯수만큼 for문 반복
      $tr=$("<tr>");
      //<tr></tr>
      for(var j=0;j<elem.eq(i).children().length;j++){
         $td=$("<td>").append(elem.eq(i).children().eq(j).text());
         /* 첫번째 ROW 불러와서 처리하는 과정.
            <td>100</td>
            <td>KING</td>
            <td>SKING</td>
            <td>515.123.4567</td>
            <td>1987. 6. 17 dhwjs 12:00:00</td>
          */
         $tr.append($td);
         /* <tr>
                <td>100</td>
                <td>KING</td>
                <td>SKING</td>
                <td>515.123.4567</td>
                <td>1987. 6. 17 dhwjs 12:00:00</td>
            </tr>
          */
      }
      $table.append($tr);
      /*
         <table border=1> 
            <tr>
                <td>100</td>
                <td>KING</td>
                <td>SKING</td>
                <td>515.123.4567</td>
                <td>1987. 6. 17 dhwjs 12:00:00</td>
            </tr>
            <tr>
                <td></td>
                ....
            </tr>
            ....
        </table>
       */
   }
   return $table;
   
}