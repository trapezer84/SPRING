let $books := doc("src/kr/co/hucloud/xquery/xml/books.xml")
return <table><tr><th>Title</th><th>Price</th></tr>
{
   for $x in $books/books/book
   order by $x/price ascending
   return <tr><td>{data($x/title)}</td><td>{data($x/price)}</td></tr>
}
</table>
(: 
	return 값에 패턴을 지정할 수 있다.
	return <결과를 둘러쌀 값>
	{
		for $x in $books/books/book
   		order by $x/price ascending
   					   {} 이 기호는 xquery 에서 함수를 사용하기 위한 기호
   					   { .. } 없이 data(...) 를 적으면 data(...) 함수는 일반 텍스트로 인식한다.
   		return <tr><td>{data($x/title)}</td><td>{data($x/price)}</td></tr>
	}
	<결과를 둘러 쌀 값>
:)