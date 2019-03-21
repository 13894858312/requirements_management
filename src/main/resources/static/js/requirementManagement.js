
/**
 * 进入筛选需求
 * @param pid
 */
function goToFiltrateRequires(pid) {
    window.location.href = '/filtrateRequires?pid=' + pid;
}

/**
 * 跳转筛选结果页
 * @param pid
 */
function goToFiltrateResult(pid){
    window.location.href = '/filtrateResult?pid=' + pid;
}