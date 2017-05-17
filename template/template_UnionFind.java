/**
 * Union Find 模板
 * 两个操作时间复杂度为0
 */

HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

// Find
int find(int x) {
    int parent = x;
    while (parent != father.get(parent)) {
        parent = father.get(parent);
    }
    return parent;
}

// Union
void union (int x, int y) {
    int fa_x = find(x);
    int fa_y = find(y);
    if (fa_x != fa_y) 
        father.put(fa_x, fa_y);
}

// 完整模板，时间复杂度为O(1)
class UnionFind {
    UnionFind(){}
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

    // Find
    int find(int x) {
        int parent = x;
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        return parent;
    }

    // Union
    void union (int x, int y) {
        int fa_x = find(x);
        int fa_y = find(y);
        if (fa_x != fa_y) 
            father.put(fa_x, fa_y);
    }
}

// 路径压缩查询
int compressed_find(int x) {
    // 扫描一，找到parent
    int parent = x;
    while (parent != father.get(parent)) {
        parent = father.get(parent);
    }
    // 扫描二，依次设置
    int temp = -1;
    int fa = x;
    while (fa != father.get(x)) {
        temp = father.get(fa);
        father.put(fa, parent);
        fa = temp;
    }
    return parent;
}