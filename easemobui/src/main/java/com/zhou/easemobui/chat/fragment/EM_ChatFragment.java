package com.zhou.easemobui.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMChatRoom;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMGroup;
import com.easemob.chat.core.EMConnectionManager;
import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.adapter.EM_ChatMessageAdapter;
import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;
import com.zhou.easemobui.common.EM_ChatBaseFragment;
import com.zhou.easemobui.main.EaseMobUIClient;
import com.zhou.easemobui.model.opposite.EM_ChatBuddy;
import com.zhou.easemobui.model.opposite.EM_ChatConversationObject;
import com.zhou.easemobui.model.opposite.EM_ChatGroup;
import com.zhou.easemobui.model.opposite.EM_ChatOpposite;
import com.zhou.easemobui.model.opposite.EM_ChatRoom;
import com.zhou.easemobui.model.opposite.EM_ChatUser;

/**
 * Created by ZhouYuzhen on 15/11/7.
 */
public class EM_ChatFragment extends EM_ChatBaseFragment implements
        SwipeRefreshLayout.OnRefreshListener,
        AbsListView.OnScrollListener, View.OnClickListener {

    private static final String TAG = EM_ChatFragment.class.getName();

    private SwipeRefreshLayout refreshLayout;
    private ListView mListView;
    private View mChatToolMore;
    private TextView mActionTv;
    private TextView mEmojiTv;
    private TextView mVoiceTv;

    private EM_ChatToolAction mToolAction;
    private EM_ChatToolVoice mToolVoice;
    private EM_ChatToolEmoji mToolEmoji;
    private Fragment mHideToolFragment;

    private EM_ChatMessageAdapter mAdapter;

    //config
    private EM_ChatToolConfig mToolConfig;
    private Bundle mBundle;
    private EMConversation mConversation;
    private EM_ChatOpposite mOpposite;
    private EM_ChatUser mUser;
    private EaseMobUIClient mClient = EaseMobUIClient.sharedInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new EM_ChatMessageAdapter();
        mBundle = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.em_fragment_chat, container);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.em_chat_message_swipe_refresh);
        refreshLayout.setOnRefreshListener(this);

        mListView = (ListView) view.findViewById(R.id.em_chat_message_list_view);
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(this);

        mActionTv = (TextView) view.findViewById(R.id.em_chat_message_tool_action);
        mActionTv.setOnClickListener(this);
        mEmojiTv = (TextView) view.findViewById(R.id.em_chat_message_tool_emoji);
        mEmojiTv.setOnClickListener(this);
        mVoiceTv = (TextView) view.findViewById(R.id.em_chat_message_tool_voice);
        mVoiceTv.setOnClickListener(this);
        mChatToolMore = view.findViewById(R.id.em_chat_message_tool_more);

        return view;
    }

    @Override
    public void setArguments(Bundle args) {
        if (this.isInLayout()) {
            if (args != null && args != mBundle) {
                mBundle = args;
            }

        } else {
            super.setArguments(args);
        }
    }

    private void reloadConversation(boolean reloadMessage) {
        if (mClient.getUserDelegate() == null) {
            Log.d(TAG, "is not set user delegate");
        }
        mUser = mClient.getUserDelegate().getUserInfo();
        if (mUser == null) {
            mUser = new EM_ChatUser(EMChatManager.getInstance().getCurrentUser());
        }
        if (mUser.getUid() == null) {
            Log.d(TAG, "Current user is not login");
        }
        if (mBundle == null) {
            throw new IllegalArgumentException("The opposite uid and opposite type is null,or opposite object is null");
        }
        mOpposite = mBundle.getParcelable(EM_ChatConversationObject.KEY_CONVERSATION_OBJECT);
        if (mOpposite == null) {
            String oppositeUid = mBundle.getString(EM_ChatConversationObject.KEY_CONVERSATION_UID);
            if (oppositeUid == null) {
                throw new IllegalArgumentException("opposite uid is null");
            }
            int oppositeTypeId = mBundle.getInt(EM_ChatConversationObject.KEY_CONVERSATION_TYPE);
            if (oppositeTypeId != EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeChat.getOppositeId() ||
                    oppositeTypeId != EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeGroup.getOppositeId() ||
                    oppositeTypeId != EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeRoom.getOppositeId()) {
                throw new IllegalArgumentException("opposite id must be EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeChat.getOppositeId() or EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeGroup.getOppositeId() or EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeRoom.getOppositeId()");
            }
            EM_ChatOpposite.EM_ChatOppositeType oppositeType = EM_ChatOpposite.EM_ChatOppositeType.getOppositeTypeById(oppositeTypeId);
            if (mClient.getOppositeDelegate() == null) {
                Log.d(TAG, "is not set opposite delegate");
                if (oppositeType == EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeChat) {
                    mOpposite = new EM_ChatBuddy(oppositeUid);
                } else if (oppositeType == EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeGroup) {
                    EMGroup group = EMChatManager.getInstance().getGroup(oppositeUid);
                    EM_ChatGroup mGroup;
                    if (group != null) {
                        mGroup = new EM_ChatGroup(group);
                    } else {
                        mGroup = new EM_ChatGroup(oppositeUid);
                    }
                    mOpposite = mGroup;
                } else if (oppositeType == EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeRoom) {
                    EMChatRoom room = EMChatManager.getInstance().getChatRoom(oppositeUid);
                    EM_ChatRoom mRoom;
                    if (room != null) {
                        mRoom = new EM_ChatRoom(room);
                    } else {
                        mRoom = new EM_ChatRoom(oppositeUid);
                    }
                    mOpposite = mRoom;
                }
            } else {
                if (oppositeType == EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeChat) {
                    mOpposite = mClient.getOppositeDelegate().getBuddyInfo(oppositeUid);
                } else if (oppositeType == EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeGroup) {
                    mOpposite = mClient.getOppositeDelegate().getGroupInfo(oppositeUid);
                } else if (oppositeType == EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeRoom) {
                    mOpposite = mClient.getOppositeDelegate().getRoomInfo(oppositeUid);
                }
            }

            if (mOpposite == null) {
                throw new IllegalArgumentException("opposite is null");
            }
        }
        EMConversation.EMConversationType conversationType;
        if (mOpposite.oppositeType() == EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeGroup) {
            conversationType = EMConversation.EMConversationType.GroupChat;
        } else if (mOpposite.oppositeType() == EM_ChatOpposite.EM_ChatOppositeType.EM_ChatOppositeTypeRoom) {
            conversationType = EMConversation.EMConversationType.ChatRoom;
        } else {
            conversationType = EMConversation.EMConversationType.Chat;
        }
        mConversation = EMChatManager.getInstance().getConversationByType(mOpposite.getUid(), conversationType);
        mConversation.markAllMessagesAsRead();

    }


    public EM_ChatToolConfig getToolConfig() {
        if (mToolConfig == null) {
            mToolConfig = new EM_ChatToolConfig(getContext());
        }
        return mToolConfig;
    }

    @Override
    public void onClick(View v) {
        Fragment showToolFragment = null;
        boolean isAdd = false;
        if (v.getId() == R.id.em_chat_message_tool_action) {
            if (mHideToolFragment != null && mHideToolFragment == mToolAction) {
                return;
            }
            if (isAdd = mToolAction == null) {
                mToolAction = new EM_ChatToolAction();
            }
            showToolFragment = mToolAction;
        } else if (v.getId() == R.id.em_chat_message_tool_voice) {
            if (mHideToolFragment != null && mHideToolFragment == mToolVoice) {
                return;
            }
            if (isAdd = mToolVoice == null) {
                mToolVoice = new EM_ChatToolVoice();
            }
            showToolFragment = mToolVoice;
        } else if (v.getId() == R.id.em_chat_message_tool_emoji) {
            if (mHideToolFragment != null && mHideToolFragment == mToolEmoji) {
                return;
            }
            if (isAdd = mToolEmoji == null) {
                mToolEmoji = new EM_ChatToolEmoji();
            }
            showToolFragment = mToolEmoji;
        }
        if (showToolFragment != null) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.em_chat_tool_enter, R.anim.em_chat_tool_exit);
            if (mHideToolFragment != null) {
                transaction.hide(mHideToolFragment);
            }
            if (isAdd) {
                transaction.add(R.id.em_chat_message_tool_more, showToolFragment);
            } else {
                transaction.show(showToolFragment);
            }

            transaction.commit();
            mHideToolFragment = showToolFragment;
        }

        if (mChatToolMore.getVisibility() == View.GONE) {
            TranslateAnimation mShowAction = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);
            mShowAction.setDuration(500);
            mChatToolMore.startAnimation(mShowAction);
            mChatToolMore.setVisibility(View.VISIBLE);
        }
    }

    //OnRefreshListener
    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(false);
    }

    //OnScrollListener
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }
}