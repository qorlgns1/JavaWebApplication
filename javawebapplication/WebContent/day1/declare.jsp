<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quick Sort</title>

<style>
	span{
		border:2px solid blue;
	}
</style>

</head>
<body>
	<!-- 메소드나 변수 선언 -->
	<%!
		//quick sort
		//배열에서 첫번째 데이터를 기준 데이터로 선정
		//첫번째 데이터와 나머지 모든 데이터를 비교해서 작으면 왼쪽
		//크면 오른쪽으로 배치를 하고 기준 데이터의 왼쪽 부분과 
		//오른쪽 부분 배열을 재귀적으로 다시 작업을 수행시키는 방식
		//데이터의 개수가 1개이면 종료
		//데이터의 개수가 1개인 것은 시작위치보다 종료 위치가 크지 않은 경우
	
		//시작위치와 종료위치 그리고 배열을 매개변수로 받아서
		//quick sort를 수행해주는 메소드
		public void quicksort(
			int left, int right, int [] data){
			//현재 배열의 상태 출력
			for(int i : data){
				System.out.print(i + "\t");
			}
			System.out.println();
			
			//기준이 되는 위치를 설정
			int pivot = left;
			//기준 데이터가 이동해야 할 위치를 저장할 변수
			//pivot 위치의 데이터보다 작은 데이터를 만나면 1증가
			int j = pivot;
			//비교할 위치를 저장할 변수 - 반복문에서 사용
			int i = left + 1;
			
			//데이터가 2개 이상이면
			if(left < right){
				//기준 위치 다음부터 끝까지 기준 위치의 데이터와 비교
				for(; i <= right; i=i+1){
					//기준 위치의 데이터가 더 크다면
					if(data[i] < data[pivot]){
						//기준 데이터가 위치해야 할 지점을 1칸 이동
						j = j + 1;
						//i번째와 j번째 데이터를 교환
						int temp = data[j];
						data[j] = data[i];
						data[i] = temp;
					}
				}
				
				//기준 데이터를 자신의 자리로 이동
				int temp = data[left];
				data[left] = data[j];
				data[j] = temp;
				
				//기준 위치를 수정
				pivot = j;
				
				//왼쪽 부분과 오른쪽 부분을 재귀적으로 수행
				quicksort(left, pivot-1, data);
				quicksort(pivot+1, right, data);
			}
		}
	%>
	
	<%
		//정렬할 데이터 만들기
		int [] ar = {30, 28, 29, 38, 51, 7, 21, 5, 19};
	%>
	
	<h2>정렬하기 전 데이터</h2>
	<%
		for(int temp : ar){
	%>
	<span><%=temp %></span>
	<%
		}
	%>
	
	<%
		quicksort(0, ar.length-1, ar);
	%>
	<h2>정렬한 후의 데이터</h2>
	<%
		for(int temp : ar){
	%>
	<span><%=temp %></span>
	<%
		}
	%>
</body>
</html>


