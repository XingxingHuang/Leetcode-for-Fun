// 对撞型指针优化算法
if (考虑A[i]和A[j]满足某个条件)
    j--;
    do something;
else if (考虑A[i]和A[j]不满足某个条件)
    i++;
    do something;
else 
    do something;
    i++ or j--;
    
    
// 窗口类指针移动模板
// 通过两层for循环的改进算法，不同于sliding window
for (i = 0; i < n; i++) {
    while (j < n) {
        if (满足条件)
            j++;
            更新j状态;
        else (不满足条件)
            break;
    }
    更新状态;
}