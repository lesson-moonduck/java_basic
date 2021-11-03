import { atom } from "recoil"

const allState = {
    "conversations": atom({ key: "conversations", default: []})
}

export default allState