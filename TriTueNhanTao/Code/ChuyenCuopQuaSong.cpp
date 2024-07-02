#include<bits/stdc++.h>
#define ll long long
#define MAX 1e9+7
#define MIN -1e9+7
#define f first
#define s second
using namespace std;
class Chuyen{
	int phu;
	int cuop;
	bool bo;
	public :
		Chuyen();
		Chuyen(int a, int b, bool c){
		phu = a;
		cuop = b;
		bo = c;
	}
};
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	Chuyen *bt = new Chuyen(3,3,true);
	pair<int, int> c1, c2, c3, c4, c5;
	c1.first = 1; c1.second = 0;
	c2.first = 0; c2.second = 1;
	c3.first = 2; c3.second = 0;
	c4.first = 0; c4.second = 2;
	return 0;
	}


