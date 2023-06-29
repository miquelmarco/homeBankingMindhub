let { createApp } = Vue;
createApp({
    data() {
        return {
            transactions: [],
            queryId: '',
            transInDescenOrder:[]
        }
    },
    created() {
        this.loadData()
    },
    methods: {
        loadData() {
            this.queryId = new URLSearchParams(location.search).get('id')
            axios.get(`http://localhost:8080/api/accounts/${this.queryId}`)
                .then(res => {
                    this.transactions = res.data.transactions
                    console.log(this.transactions)
                }).catch(err => console.error(err))
        },
        changeClassByTransaction(transaction) {
            if (transaction.type === 'DEBIT') {
                return 'debit';
            } else if (transaction.type === 'CREDIT') {
                return 'credit';
            } else {
                return 'standarTable';
            }
        },
        sessionLogOut() {
            axios.post("/api/logout")
            .then(res => {
                window.location.href = "/web/index.html"
                console.log("signedOUT")
            }).catch(err => {console.log(err)})
        }
    },
    computed: {
        orderedTransactions () {
            let transInDescenOrder = [...this.transactions]
            transInDescenOrder.sort((a, b) => b.id - a.id)
            return transInDescenOrder
        },
        closeAlert() {
            var alert = document.querySelector('.customAlert');
            alert.style.display = 'none';
        }
    }
}).mount("#app")