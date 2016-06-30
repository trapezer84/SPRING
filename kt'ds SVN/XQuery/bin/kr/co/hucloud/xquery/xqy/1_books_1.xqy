declare variable $path external;
let $xmlDoc := doc($path)
for $x in $xmlDoc/books/book
where $x/price>30
return <table>
	<tr><td>$x/title</td></tr>
</table>
(: 주석입니다 :)
(: 
	let은 variable type의 변수형이다,
	변수명의 표현은 "$변수명" 으로 한다.
	변수에 값을 대입하기 위해서는 "$변수명 := 값" 의 형태로 대입한다.
	
	doc("xml 파일의 경로") 는 xml 파일을 Document로 읽어오는 함수다.
	상대경로와 절대경로를 사용할 수 있다.
	상대경로는 프로젝트의 Classpath가 기준이 된다.
	절대경로는 드라이브 코드의 시작부터 작성하면 된다.
	
	아래 코드는 상대경로에 존재하는 books.xml 파일을 읽어와 xmlDoc 변수에 대입하는 코드다.
let $xmlDoc := doc("src/kr/co/hucloud/xquery/xml/books.xml")

	xmlDoc에는 books.xml 의 내용이 들어있다.
	xml 내용 중 books 엘리먼트(루트)의 book 엘리먼트(List 타입)를 가져와 반복하며 x 변수에 대입한다.
for $x in $xmlDoc/books/book

	개별의 book 엘리먼트마다 price 하위 엘리먼트의 값이 30보다 큰지(초과하는지) 체크한다.
where $x/price>30

	초과 한다면 book 엘리먼트의 title 하위 엘리먼트의 값을 반환한다.
return $x/title
:)