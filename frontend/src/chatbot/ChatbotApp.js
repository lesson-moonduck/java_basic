import { Comment, Avatar, Input } from 'antd'
import { SmileTwoTone, RedditOutlined } from '@ant-design/icons'
import { useRecoilState } from 'recoil'
import allState from '../states/State'
import 'antd/dist/antd.css'


function getIcon(user) {
    if (user === "pacman") {
        return <SmileTwoTone />
    } else {
        return <RedditOutlined color="#eb2f96" />
    }
}

function getKey(id) {
    return "u" + id
}

function ChatbotApp(props) {

    const [conversations, setConversations] = useRecoilState(allState["conversations"])

    const pressEnter = (e) => {
        const text = e.target.value
        const nextId = conversations.length ? conversations[conversations.length - 1]["id"] + 1 : 0
        const withUserSentence = conversations.concat({id: nextId, "user": "user", "text": text, "key": getKey(nextId) })
        setConversations(withUserSentence)
        //call api
        fetch("http://localhost:8080/chat/response?sentence=" + text)
            .then(res => res.text())
            .then(text => {
                const convId = nextId + 1
                setConversations(withUserSentence.concat({id: convId,"user": "pacman", "text": text, "key": getKey(convId) }))
            })
            .catch(console.log)
        
    }

    return <div>
        <div>
            <Input onPressEnter={pressEnter}/>
        </div>
        <div>
        {
            conversations.map(conv => {
                return <Comment avatar={<Avatar icon={getIcon(conv.user)}/>} content={
                    <p>{conv.text}</p>    
                }/>
            })
        }
        </div>
    </div>
}


export default ChatbotApp