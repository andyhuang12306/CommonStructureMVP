# CommonStructureMVP
this is a simple MVP structure can be used for projects mainly to decouple the V from P and M to avoid Memory Leak

# Main Components

BaseView: Activity{
    p: P

    fun onCreate(){
        p=getP()
        p.bind(this)
    }

    fun getP(): P

    fun onDestory(){
        p.unBind()
    }

    fun getContract(): CONTRACT
}

BaseModel(p:P){
    p=p

    fun getContract(): CONTRACT
}

BasePresenter{
    m:M
    weakRef: WeakReference

    fun bind(v:V){
        WeakReference<V>(v)
    }

    fun unBind(){
        weakRef?.clear()
        weakRef?=null
        System.gc()
    }

    fun getV(): V{
        return weakRef?.get()
    }

    fun getContract(): CONTRACT
    fun getM(): M

}
