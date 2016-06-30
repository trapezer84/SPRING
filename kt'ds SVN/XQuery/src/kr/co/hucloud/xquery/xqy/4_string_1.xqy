let $bookTitle := "Learn XQuery in 24 hours"
let $size := string-length($bookTitle)

return
   <result>   
      <size>{$size}</size>
   </result>
   
(: 
	글자의 길이를 구한다.
:)