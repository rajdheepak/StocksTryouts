

fun main(args: Array<String>) {
    val stockPrices: Array<Long> = arrayOf(3, 2, 3, 4, 40, 5)
    val stockPrices1: Array<Long> = arrayOf(3, 2, 3, 4, 40, 5, 6)
    val stockPrices2: Array<Long> = arrayOf(3, 2, 3, 4, 5, 1)
    val stockPrices3: Array<Long> = arrayOf()
    val stockPrices4: Array<Long> = arrayOf(3, 45, 87, 90, 7, 2, 6, 9)
    print(getLargestProfit(stockPrices))
    print('\n')
    print(getLargestProfit(stockPrices1))
    print('\n')
    print(getLargestProfit(stockPrices2))
    print('\n')
    print(getLargestProfit(stockPrices3))
    print('\n')
    print(getLargestProfit(null))
    print('\n')
    print(getLargestProfit(stockPrices4))

    print('\n')
    print('\n')
    print('\n')

    print(getLargestProfitOptimum(stockPrices))
    print('\n')
    print(getLargestProfitOptimum(stockPrices1))
    print('\n')
    print(getLargestProfitOptimum(stockPrices2))
    print('\n')
    print(getLargestProfitOptimum(stockPrices3))
    print('\n')
    print(getLargestProfitOptimum(null))
    print('\n')
    print(getLargestProfitOptimum(stockPrices4))
}

private fun getLargestProfitOptimum(stockPrices: Array<Long>?): Long {
    var MAX_PROFIT: Long = 0
    val MIN_DIFF = 5
    if(stockPrices == null || stockPrices.size < 5) {
        return MAX_PROFIT
    }
    var minimumBuyingPrice = stockPrices.first()
    for(i in MIN_DIFF until stockPrices.size) {
        minimumBuyingPrice = if(minimumBuyingPrice < stockPrices[i-MIN_DIFF]) minimumBuyingPrice else stockPrices[i-MIN_DIFF]
        MAX_PROFIT = if(MAX_PROFIT > stockPrices[i] - minimumBuyingPrice) MAX_PROFIT else stockPrices[i] - minimumBuyingPrice
    }
    return MAX_PROFIT
}

private fun getLargestProfit(stockPrices: Array<Long>?): Long {
    var MAX_PROFIT: Long = 0
    val MIN_DIFF = 5
    if(stockPrices == null || stockPrices.size < 5) {
        return MAX_PROFIT
    }
    val profits = mutableListOf<Long>()
    loop@ for(i in 0 until stockPrices.size) {
        if(i+MIN_DIFF <= stockPrices.size) {
            for(j in 0 until stockPrices.size - MIN_DIFF - i) {
                profits.add(stockPrices[i + MIN_DIFF + j] - stockPrices[i])
            }
        } else {
            break@loop
        }
    }
    profits.forEach {
        if(it > MAX_PROFIT) {
            MAX_PROFIT = it
        }
    }
    return MAX_PROFIT
}