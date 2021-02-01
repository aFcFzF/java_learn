var enu = {
    LEFT: 'left',
    RIGHT: 'right',
    TOP: 'top',
    BOTTOM: 'bottom'
};

var numIslands = function(grid) {
const record = Array.from({length: grid.length}, () => new Array(grid[0].length).fill(false));

    const dfs = (i, j) => {

        if (!grid[i]?.[j] || grid[i]?.[j] === '0' || record[i]?.[j]) {
            return;
        }

        record[i][j] = true;

        dfs(i - 1, j, enu.LEFT);
        dfs(i + 1, j, enu.RIGHT);
        dfs(i, j - 1, enu.TOP);
        dfs(i, j + 1, enu.BOTTOM);


    };

let count = 0;

    for (const [i, row] of grid.entries()) {


        for (const [j, item] of row.entries()) {
            if (record[i][j] || grid[i][j] === '0') {
                continue;
            }

            debugger;

            dfs(i, j);
            count++;
        }
    }
    return count;
};
