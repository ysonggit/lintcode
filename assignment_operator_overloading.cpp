class Solution {
public:
    char *m_pData;
    Solution() {
        this->m_pData = NULL;
    }
    Solution(char *pData) {
        this->m_pData = pData;
    }
    /**
     * http://guitarpenguin.is-programmer.com/posts/40909.html
     */
    // Implement an assignment operator
    Solution & operator=(const Solution &object) {
        if(object.m_pData==NULL) return *this; // mistake : input A = D, D.m_pData = NULL;
        if(this == & object) return *this;
        delete[]  m_pData; // release memory before assign new memory space
        m_pData = NULL;
        m_pData = new char[strlen(object.m_pData)+1];
        strcpy(m_pData, object.m_pData);
        return *this;
    }
};
