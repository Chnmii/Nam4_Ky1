 #include<bits/stdc++.h>

#define REP(i , l , r) for(int i = l ; i <= r ; i++)
#define REPD(i , l , r) for(int i = l ; i >= r ; i--)
#define REPS(i , l , r) for(int i = l ; i < r ; i++)

typedef long long int ll;

using namespace std;

enum facing {
	LEFT , RIGHT , UP , DOWN , STAY
};

int puzzle[3][3] , posX , posY , checker , cost;

class node{
	public :
		int arr[3][3] , x , y , f;
		string way;
		facing canFace;
		
		node(int a[3][3] , string way , facing canFace , int x , int y , int f){
			this->f = f;
			this->way = way;
			this->canFace = canFace;
			this->x = x;
			this->y = y;
			REP(i,0,2){
				REP(j,0,2){
					arr[i][j] = a[i][j];
				}
			}
		}
		
		bool canMoveLeft(){
			return canFace != LEFT && y > 0 && cost > herStic();
		}
		bool canMoveRight(){
			return canFace != RIGHT && y < 2 && cost > herStic();
		}
		bool canMoveUp(){
			return canFace != UP && x > 0 && cost > herStic();
		}
		bool canMoveDown(){
			return canFace != DOWN && x < 2 && cost > herStic();
		}
		
		int herStic(){
			int sum = 0;
			if(checker == 1){
				if(arr[0][0] != 1) sum++;
				if(arr[0][1] != 2) sum++;
				if(arr[0][2] != 3) sum++;
				if(arr[1][0] != 8) sum++;
				if(arr[1][2] != 4) sum++;
				if(arr[2][0] != 7) sum++;
				if(arr[2][1] != 6) sum++;
				if(arr[2][2] != 5) sum++;
			}else{
				if(arr[0][1] != 1) sum++;
				if(arr[0][2] != 2) sum++;
				if(arr[1][0] != 3) sum++;
				if(arr[1][1] != 4) sum++;
				if(arr[1][2] != 5) sum++;
				if(arr[2][0] != 6) sum++;
				if(arr[2][1] != 7) sum++;
				if(arr[2][2] != 8) sum++;
			}
			return sum + f;
		}
		
		void moveLeft(){
			swap(arr[x][y] , arr[x][y-1]);
			y--;
			canFace = RIGHT;
			way += "l";
			f++;
		}
		void moveRight(){
			swap(arr[x][y] , arr[x][y+1]);
			y++;
			canFace = LEFT;
			way += "r";
			f++;
		}
		void moveUp(){
			swap(arr[x][y] , arr[x-1][y]);
			x--;
			canFace = DOWN;
			way += "u";
			f++;
		}
		void moveDown(){
			swap(arr[x][y] , arr[x+1][y]);
			x++;
			canFace = UP;
			way += "d";
			f++;
		}
		
		bool checkFinish(){
			if(checker == 1){
				REP(i,0,2){
					if(arr[0][i] != i+1 || arr[2][i] != 7-i) return false;;
				}
				return arr[1][0] != 8 || arr[1][2] != 4 ? false : true;
			}else{
				REP(i,0,2){
					if(arr[0][i] != i || arr[1][i] != i+3 || arr[2][i] != i+6) return false;
				}
				return true;
			}
			
		}
};

void moveLeft(){
	swap(puzzle[posX][posY] , puzzle[posX][posY-1]);
	posY--;
}
void moveRight(){
	swap(puzzle[posX][posY] , puzzle[posX][posY+1]);
	posY++;
}
void moveUp(){
	swap(puzzle[posX][posY] , puzzle[posX-1][posY]);
	posX--;
}
void moveDown(){
	swap(puzzle[posX][posY] , puzzle[posX+1][posY]);
	posX++;
}

void initPuzzle(){
	cout << "Nhap cac gia tri cho puzzle : ";
	cin >> puzzle[0][0] >> puzzle[0][1] >> puzzle[0][2];
	cin >> puzzle[1][0] >> puzzle[1][1] >> puzzle[1][2];
	cin >> puzzle[2][0] >> puzzle[2][1] >> puzzle[2][2];
	cout << "Nhap chi phi toi da cua thuat toan = ";
	cin >> cost;
	
	bool checked = true;
	int sum = 0;
	REP(i,0,2){
		REP(j,0,2){
			sum += puzzle[i][j];
			if(puzzle[i][j] > 8) {
				checked = false;
				break;
			}
		}
	}
	if(sum != 36 || checked == false){
		cout << "Nhap sai du lieu vui long nhap lai" << endl;
		return initPuzzle();
	}
	
	REP(i,0,2){
		REP(j,0,2){
			if(puzzle[i][j] == 0){
				posX = i;
				posY = j;
				return;
			}
		}
	}
}

void prin(){
	REP(i,0,2){
		REP(j,0,2){
			cout << puzzle[i][j] << " ";
		}
		cout << endl;
	}
}
		
bool checkFinish(){
	int counter1 = 0, counter2 = 0;
	REP(i,0,2){
		if(puzzle[0][i] == i+1) counter1++;
	}
	
	REP(i,0,2){
		if(puzzle[2][i] == 7-i) counter1++;
	}
	if(puzzle[1][0] == 8){
		counter1++;
	} 
	if(puzzle[1][2] == 4) {
		counter1++;
	}
	if(counter1 == 8) return true;
		
	REP(i,0,2){
		if(puzzle[0][i] == i) counter2++;
		if(puzzle[1][i] == i+3) counter2++;
		if(puzzle[2][i] == i+6) counter2++;
	}
	if(counter2 == 8) return true;
	return false;
}

int countStart(){
	int sum = 0;
	REP(q,0,8){
		int row = q/3;
		int col = q%3;
		int counter = puzzle[row][col];
		REP(i,0,2){
			REP(j,0,2){
				if( (row < i && puzzle[i][j] < counter && puzzle[i][j] != 0 )  ){
					sum++;
				}else if(row == i && col < j && puzzle[i][j] < counter && puzzle[i][j] != 0){
					sum++;
				}
			}
		}
	}
	return sum;
}

int main(){
	int step = 0 ;
	ll numOfNode = 0;
	bool check = checkFinish();
	initPuzzle();
	const clock_t begin_time = clock();
	string way = "";
	node nd(puzzle , "" , STAY , posX , posY , 0);
	vector<node> vt;
	vt.push_back(nd);
	checker = countStart() %2;
	cout << "Trang thai ban dau : " << endl;
	prin();
	cout << endl;
	while(!check && vt.size() != 0){
		vector<node> open;
			int i = vt.size()-1;
			if(vt.at(i).checkFinish()){
				way = vt.at(i).way;
				check = true;
				break;
			}else{
				if(vt.at(i).canMoveUp()){
					node nd = vt.at(i);
					nd.moveUp();
					open.push_back(nd);
				}
				if(vt.at(i).canMoveDown()){
					node nd = vt.at(i);
					nd.moveDown();
					open.push_back(nd);
				}
				if(vt.at(i).canMoveRight()){
					node nd = vt.at(i);
					nd.moveRight();
					open.push_back(nd);
				}
				if(vt.at(i).canMoveLeft()){
					node nd = vt.at(i);
					nd.moveLeft();
					open.push_back(nd);
				}
			}
			vt.pop_back();
			
		REPS(i,0,open.size()){
			REPS(j,i+1,open.size()){
				if(open.at(i).herStic() <= open.at(j).herStic()){
					swap(open.at(i) , open.at(j));
				}
			}
			
		}
		REPS(i,0,open.size()){
			if(open.at(i).herStic() == open.at(open.size()-1).herStic())
			vt.push_back(open.at(i));
		}
		numOfNode++;
	}
	if(!check){
		cout << "Thuat toan that bai , khong tim duoc dich";
		return 0;
	}
	REPS(i,0,way.length()){
		if(way[i] == 'l'){
			moveLeft();
			prin();
			cout << "di chuyen sang trai" << endl << endl;
		}else if(way[i] == 'r'){
			moveRight();
			prin();
			cout << "di chuyen sang phai" << endl << endl;
		}else if(way[i] == 'u'){
			moveUp();
			prin();
			cout << "di chuyen len tren" << endl << endl;
		}else if(way[i] == 'd'){
			moveDown();
			prin();
			cout << "di chuyen xuong duoi" << endl << endl;
		}
	}
	cout << "Thuat toan AKT" << endl;
	cout << "So buoc di = " << way.length() << endl;
	cout << "So phep toan da thuc hien = " << numOfNode << endl;
	cout << "Thoi gian tinh toan = " << float( clock () - begin_time ) /  CLOCKS_PER_SEC << "s";
	return 0;
}
