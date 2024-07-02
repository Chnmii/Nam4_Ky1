
ơ#include<bits/stdc++.h>
#define x first
#define y second
#define pi pair<int, string>
#define pii pair<int, pi>
#define piii pair<int, pi>
#define piiii pair<int, piii>
using namespace std;
class BreathFirstSearch{

queue<string> Q;
queue<string> temp;
map<string, int> visit;
map<string, vector<string>> graph;
map<string, string> revert;
string start, stop;
public:
	int BFS(string root){
		Q.push(root);
		visit[root] = 1;
		while(!Q.empty()){
			string x = Q.front();
			Q.pop();
			cout << setw(10) << x << setw(10) << " |";
			if(x == stop){
				cout << "\n found \n";
				return 1;
			}
			string str = "";
			for(auto i: graph[x]){
				str += " " + i + " ";
				if(visit.find(i) == visit.end()){
					revert[i] = x;
					Q.push(i);
					visit[i] = 1;
				}
			}
			cout << str << setw(22 - str.size()) << " |";
			temp = Q;
			while(!temp.empty()){
				cout << temp.front().c_str() << " ";
				temp.pop();
			}
			cout << endl;
		}
		return 0;
	}
	void printPath(string des){
		cout << revert[des] << (revert[des]== start?" " : " <- ");
		while(revert.find(revert[des]) != revert.end()){
			printPath(revert[des]);
			return;
		}
	}
	void solve(){
		int n;
		cin >> n;
		for(int i = 0; i < n ; i++){
			int a, c;
			string b;
			cin >> a >> b >> c;
			for(int j = 0; j < a; j++){
				string x;
				int d, e;
				cin >> x >> d >> e;
				graph[b].push_back(x);
			}		
		}
		cin >> start >> stop;
		cout<<setw(20)<<"Phat trien tran thai"<<setw(20)<<"Trang thai ke"<<setw(20)<<"Danh Sach L"<<endl;
		cout<<"=================================================================================="<<endl;
		int found = BFS(start);
		if(found){
			cout << stop << " <- ";	
			printPath(stop);
		}else{
			cout << "Not Found";
		}
	}
};
class ASao{
	public:
		
	priority_queue<piiii, vector<piiii>, greater<piiii>> Q;
	priority_queue<piiii, vector<piiii>, greater<piiii>> temp;
	map<string, int> visit;
	map<pi, vector<pii>> graph;
	map<string, string> revert;
	string start, stop;
int solve(string root, int a){
	Q.push(make_pair(0, make_pair(0, make_pair(a, root))));
	visit[root] = 1;
	
	while(!Q.empty()){
		piiii x = Q.top();
		Q.pop();
		cout << setw(10) << x.second.second.second << "-" << to_string(x.first) << setw(8) << " |";
		if(x.second.second.second == stop){
			cout << "\n found \n";
			return 1;
		}		
		int g = x.second.first;
		string str = "";
		for(auto i: graph[x.second.second]){
			int g1 = g + i.first;
			int f = g1 + i.second.first;
			str += i.second.second + " - " + to_string(i.first) + " - " + to_string(i.second.first) + " - " + to_string(g1) + " - " + to_string(f) + " ; ";
			revert[i.second.second] = x.second.second.second;
			Q.push(make_pair(f, make_pair(g1, i.second)));
		}
		cout << str << setw(90 - str.size()) << " |";
		temp = Q;
		while(!temp.empty()){
			cout << temp.top().second.second.second << "-" << temp.top().first << " ";
			temp.pop();
		}
		cout << endl;
	}
	return 0;
}
void printPath(string des){
	cout << revert[des] << (revert[des]== start?" " : " <- ");
	while(revert.find(revert[des]) != revert.end()){
		printPath(revert[des]);
		return;
	}
}
void printGraph(){
	for(auto i : graph){
		cout << i.first.second << " ";
		for(auto j : i.second){
			cout << j.second.second << " " << j.second.first << endl;
		}
		cout << endl;
	}
}
void solve1(){
	int n;
	cin >> n;
		cout<<setw(10)<<"Phat trien tran thai | "<<setw(30)<<"Trang thai ke - k - h - g - f "<<setw(90)<<"Danh Sach L"<<endl;
	cout<<"==================================================================================================================================================="<<endl;
	for(int i = 0; i < n ; i++){
		int a, c;
		string b;
		cin >> a >> b >> c;
		for(int j = 0; j < a; j++){
			string x;
			int d, e;
			cin >> x >> d >> e;
			graph[make_pair(c, b)].push_back(make_pair(e, make_pair(d, x)));
		}		
	}

	cin >> start >> stop;
	int found = solve(start, 14);
	if(found){
		cout << stop << " <- ";	
		printPath(stop);
	}else{
		cout << "Not Found";
	}
}
};
class BestFirstSearch{
	public:
		priority_queue<pi, vector<pi>, greater<pi>> Q;
priority_queue<pi, vector<pi>, greater<pi>> temp;
map<string, int> visit;
map<pi, vector<pi>> graph;
map<string, string> revert;
string start, stop;
int BFS(string root, int a){
	Q.push(make_pair(a,root));
	visit[root] = 1;
	
	while(!Q.empty()){
		pi x = Q.top();
		Q.pop();
		cout << setw(10) << x.second << "-" << to_string(x.first) << setw(8) << " |";
		if(x.second == stop){
			cout << "\n found \n";
			return 1;
		}		
		string str = "";
		for(auto i: graph[x]){
			str += " " + i.second + "-" + to_string(i.first) + " ";
			if(visit.find(i.second) == visit.end()){
				revert[i.second] = x.second;
				Q.push(i);
				visit[i.second] = 1;
			}
		}
		cout << str << setw(42 - str.size()) << " |";
		temp = Q;
		while(!temp.empty()){
			cout << temp.top().second << "-" << temp.top().first << " ";
			temp.pop();
		}
		cout << endl;
	}
	return 0;
}
void printPath(string des){
	cout << revert[des] << (revert[des]== start?" " : " <- ");
	while(revert.find(revert[des]) != revert.end()){
		printPath(revert[des]);
		return;
	}
}
void solve(){
	int n;
	cin >> n;
	cout<<setw(20)<<"Phat trien tran thai"<<setw(20)<<"Trang thai ke"<<setw(40)<<"Danh Sach L"<<endl;
	cout<<"=================================================================================="<<endl;
	for(int i = 0; i < n ; i++){
		int a, c;
		string b;
		cin >> a >> b >> c;
		for(int j = 0; j < a; j++){
			string x;
			int d, e;
			cin >> x >> d >> e;
			graph[make_pair(c, b)].push_back(make_pair(d, x));
		}		
	}
	cin >> start >> stop;
	int found = BFS(start, 14);
	if(found){
		cout << stop << " <- ";	
		printPath(stop);
	}else{
		cout << "Not Found";
	}
}
};
int main()
{
	BreathFirstSearch bfs;
	BestFirstSearch bestfs;
	ASao asao;
	int n = 0;
	do{
		cout << "------------------------------\n";
		cout << "Moi ban chon chuong trinh:\n";
		cout << "1. Breath first search\n";
		cout << "2. Best First search\n";
		cout << "3. A sao\n";
		cin >> n;
	}while(n < 1 || n > 3);
	freopen("input.txt", "r", stdin);
	switch(n){
		case 1:
			freopen("output_BreathFirstSerach.txt", "w", stdout);
			bfs.solve();
			freopen("CON", "w", stdout);
			break;
		case 2:
			freopen("output_BestFirstSearch.txt", "w", stdout);
			bestfs.solve();
			freopen("CON", "w", stdout);
			break;
		case 3:
			freopen("output_ASao.txt", "w", stdout);
			asao.solve1();
			freopen("CON", "w", stdout);
			break;
	}
	freopen("CON", "r", stdin);
	do{
		cout << "---------------------------\n";
		cout << "\nBan co muon tiep tuc:\n";
		cout << "1. Tiep tuc\n";
		cout << "0. Dung chuong trinh\n";
		cin >> n;
	}while(n < 0 || n > 1);	
	if(n){
		return main();
	}
	return 0;
}


